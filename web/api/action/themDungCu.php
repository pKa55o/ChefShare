<?php
header('Content-Type: application/json');
include_once('../conn.php'); 

$json = file_get_contents("php://input");
$data = json_decode($json, true);

// Kiểm tra dữ liệu
$id_dungcu = isset($data['id_dungcu']) ? $data['id_dungcu'] : null;
$dungcu    = isset($data['dungcu']) ? $data['dungcu'] : null;


// Thực hiện INSERT vào bảng dungcu
$sql = "INSERT INTO dungcu (id_dungcu, dungcu) VALUES ('$id_dungcu', '$dungcu')";

$result = mysqli_query($conn, $sql);

if ($result) {
    echo json_encode([
        "status" => "success",
        "message" => "Đã thêm DUNGCU thành công"
    ]);
} else {
    echo json_encode([
        "status" => "error",
        "message" => "Lỗi SQL: " . mysqli_error($conn)
    ]);
}
?>
