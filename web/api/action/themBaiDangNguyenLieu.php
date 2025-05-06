<?php
header('Content-Type: application/json');
include_once('../conn.php');

$json = file_get_contents("php://input");
$data = json_decode($json, true);

// Lấy dữ liệu
$id_baidang     = $data['id_baidang'] ? $data['id_baidang'] : NULL;
$id_nguyenlieu  = $data['id_nguyenlieu'] ? $data['id_nguyenlieu'] : NULL;

// Tạo câu lệnh INSERT vào bảng baidang_nguyenlieu
$sql = "INSERT INTO baidang_nguyenlieu (id_baidang, id_nguyenlieu) VALUES ('$id_baidang', '$id_nguyenlieu')";

// Thực thi query
$result = mysqli_query($conn, $sql);

// Trả kết quả
if ($result) {
    echo json_encode([
        "status" => "success",
        "message" => "Đã thêm BAIDANG_NGUYENLIEU thành công"
    ]);
} else {
    echo json_encode([
        "status" => "error",
        "message" => "Lỗi SQL: " . mysqli_error($conn)
    ]);
}
?>
