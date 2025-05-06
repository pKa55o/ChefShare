<?php
header('Content-Type: application/json');
include_once('../conn.php'); 

$json = file_get_contents("php://input");
$data = json_decode($json, true);


$id_baidang   = $data['id_baidang'];


$sql = "DELETE FROM baidang WHERE id_baidang = $id_baidang";

$result = mysqli_query($conn, $sql);

if ($result) {
    echo json_encode([
        "status" => "success",
        "message" => "Đã XÓA BAIDANG thành công"
    ]);
} else {
    echo json_encode([
        "status" => "error",
        "message" => "Lỗi SQL: " . mysqli_error($conn)
    ]);
}
?>
 