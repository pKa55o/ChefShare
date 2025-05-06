<?php
header('Content-Type: application/json');
include_once('../conn.php'); 

$json = file_get_contents("php://input");
$data = json_decode($json, true);

// Kiểm tra dữ liệu
$id_nguyenlieu = isset($data['id_nguyenlieu']) ? $data['id_nguyenlieu'] : null;
$nguyenlieu    = isset($data['nguyenlieu']) ? $data['nguyenlieu'] : null;



// Thực hiện INSERT vào bảng nguyenlieu
$sql = "INSERT INTO nguyenlieu (id_nguyenlieu, nguyenlieu) VALUES ('$id_nguyenlieu', '$nguyenlieu')";

$result = mysqli_query($conn, $sql);

if ($result) {
    echo json_encode([
        "status" => "success",
        "message" => "Đã thêm NGUYENLIEU thành công"
    ]);
} else {
    echo json_encode([
        "status" => "error",
        "message" => "Lỗi SQL: " . mysqli_error($conn)
    ]);
}
?>
