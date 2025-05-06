<?php
header('Content-Type: application/json');
include_once('../conn.php'); 

$json = file_get_contents("php://input");
$data = json_decode($json, true);

// Kiểm tra dữ liệu
$id_cachnau = isset($data['id_cachnau']) ? $data['id_cachnau'] : null;
$cachnau    = isset($data['cachnau']) ? $data['cachnau'] : null;

// if (!$id_cachnau || !$cachnau) {
//     echo json_encode([
//         "status" => "error",
//         "message" => "Thiếu id_cachnau hoặc cachnau"
//     ]);
//     exit;
// }

// Thực hiện INSERT vào bảng cachnau
$sql = "INSERT INTO cachnau (id_cachnau, cachnau) VALUES ('$id_cachnau', '$cachnau')";

$result = mysqli_query($conn, $sql);

if ($result) {
    echo json_encode([
        "status" => "success",
        "message" => "Đã thêm CACHNAU thành công"
    ]);
} else {
    echo json_encode([
        "status" => "error",
        "message" => "Lỗi SQL: " . mysqli_error($conn)
    ]);
}
?>
