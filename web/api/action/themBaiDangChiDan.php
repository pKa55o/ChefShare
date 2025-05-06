<?php
header('Content-Type: application/json');
include_once('../conn.php');

$json = file_get_contents("php://input");
$data = json_decode($json, true);

$id_baidang = $data['id_baidang'] ? $data['id_baidang'] : NULL;
$id_chidan = $data['id_chidan'] ? $data['id_chidan'] : NULL;;

$sql = "INSERT INTO baidang_chidan (id_baidang, id_chidan) VALUES ('$id_baidang', '$id_chidan')";

$result = mysqli_query($conn, $sql);

if ($result) {
    echo json_encode([
        "status" => "success",
        "message" => "Đã thêm BAIDANG_CHIDAN thành công"
    ]);
} else {
    echo json_encode([
        "status" => "error",
        "message" => "Lỗi SQL: " . mysqli_error($conn)
    ]);
}
?>
