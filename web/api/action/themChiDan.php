<?php
header('Content-Type: application/json');
include_once('../conn.php');


$json = file_get_contents("php://input");
$data = json_decode($json, true);


$id_baidang = $data['id_baidang'];
$id_chidan  = $data['id_chidan'];
$buoc       = $data['buoc'];
$mota       = $data['mota'];
$anh        = $data['anh'];

$sql = "INSERT INTO chidan (id_baidang, id_chidan, buoc, mota, anh) VALUES ('$id_baidang', '$id_chidan', '$buoc', '$mota', '$anh')";

$result = mysqli_query($conn, $sql);

if ($result) {
    echo json_encode([
        "status" => "success",
        "message" => "Đã thêm CHIDAN thành công"
    ]);
} else {
    echo json_encode([
        "status" => "error",
        "message" => "Lỗi SQL: " . mysqli_error($conn)
    ]);
}
?>
