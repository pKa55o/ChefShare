<?php
header('Content-Type: application/json');
include_once('../conn.php');

$json = file_get_contents("php://input");
$data = json_decode($json, true);

$id_baidang = $data['id_baidang'] ? $data['id_baidang'] : NULL;;
$id_dungcu  = $data['id_dungcu'] ? $data['id_dungcu'] : NULL;;

$sql = "INSERT INTO baidang_dungcu (id_baidang, id_dungcu) VALUES ('$id_baidang', '$id_dungcu')";

$result = mysqli_query($conn, $sql);

if ($result) {
    echo json_encode([
        "status" => "success",
        "message" => "Đã thêm BAIDANG_DUNGCU thành công"
    ]);
} else {
    echo json_encode([
        "status" => "error",
        "message" => "Lỗi SQL: " . mysqli_error($conn)
    ]);
}
?>
