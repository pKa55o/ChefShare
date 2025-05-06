<?php
header('Content-Type: application/json');
include_once('../conn.php');

$json = file_get_contents("php://input");
$data = json_decode($json, true);

$id_baidang    = $data['id_baidang'] ? $data['id_baidang'] : NULL;;
$id_nguoidung  = $data['id_nguoidung'] ? $data['id_nguoidung'] : NULL;;

$sql = "INSERT INTO baidang_dathich (id_baidang, id_nguoidung) VALUES ('$id_baidang', '$id_nguoidung')";

$result = mysqli_query($conn, $sql);

if ($result) {
    echo json_encode([
        "status" => "success",
        "message" => "Đã thêm vào BAIDANG_DATHICH thành công"
    ]);
} else {
    echo json_encode([
        "status" => "error",
        "message" => "Lỗi SQL: " . mysqli_error($conn)
    ]);
}
?>
