<?php
header('Content-Type: application/json');
include_once('../conn.php'); 

$json = file_get_contents("php://input");
$data = json_decode($json, true);

// Kiểm tra dữ liệu
$id_nguoidung  = isset($data['id_nguoidung']) ? $data['id_nguoidung'] : null;
$id_nguoitheodoi = isset($data['id_nguoitheodoi']) ? $data['id_nguoitheodoi'] : null;


// Thực hiện INSERT vào bảng theodoi
$sql = "INSERT INTO theodoi (id_nguoidung, id_nguoitheodoi) VALUES ('HFhEieJFNRNetJysnXCEi3VEtFL2', 'HFhEieJFNRNetJysnXCEi3VEtFL2')";

$result = mysqli_query($conn, $sql);

if ($result) {
    echo json_encode([
        "status" => "success",
        "message" => "Đã thêm THEODOI thành công"
    ]);
} else {
    echo json_encode([
        "status" => "error",
        "message" => "Lỗi SQL: " . mysqli_error($conn)
    ]);
}
?>
