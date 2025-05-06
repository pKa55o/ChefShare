<?php
header('Content-Type: application/json');
include_once('../conn.php'); // Kết nối có sẵn: $conn

$json = file_get_contents("php://input");
$data = json_decode($json, true);

$id_baidang = $data['id_baidang'] ? $data['id_baidang'] : NULL;
$id_cachnau = $data['id_cachnau'] ? $data['id_cachnau'] : NULL;;

$sql = "INSERT INTO baidang_cachnau (id_baidang, id_cachnau) VALUES ('$id_baidang', '$id_cachnau')";

$result = mysqli_query($conn, $sql);

if ($result) {
    echo json_encode([
        "status" => "success",
        "message" => "Đã thêm BAIDANG_CACHNAU thành công"
    ]);
} else {
    echo json_encode([
        "status" => "error",
        "message" => "Lỗi SQL: " . mysqli_error($conn)
    ]);
}
?>
