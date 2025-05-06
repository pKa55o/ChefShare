<?php
header('Content-Type: application/json');
include_once('../conn.php'); 

$json = file_get_contents("php://input");
$data = json_decode($json, true);


$id_nguoidung   = $data['id_nguoidung'];
$id_phanloai    = isset($data['id_phanloai']) ? $data['id_phanloai'] : "NULL";
$tieude         = isset($data['tieude']) ? $data['tieude'] : '';
$thumbnail      = isset($data['thumbnail']) ? "'{$data['thumbnail']}'" : "NULL";


$mota           = isset($data['mota']) ? "'{$data['mota']}'" : "NULL";
$thoigiannau    = isset($data['thoigiannau']) ? $data['thoigiannau'] : "NULL";
$khauphan       = isset($data['khauphan']) ? $data['khauphan'] : "NULL";

$sql = "INSERT INTO baidang (
    id_baidang, id_nguoidung, id_phanloai, tieude, thumbnail, mota, thoigiannau, khauphan, thoigiandang
) VALUES (
    NULL, '$id_nguoidung', $id_phanloai, '$tieude', $thumbnail, $mota, $thoigiannau, $khauphan, current_timestamp()
)";

$result = mysqli_query($conn, $sql);

if ($result) {
    echo json_encode([
        "status" => "success",
        "message" => "Đã THÊM BAIDANG thành công"
    ]);
} else {
    echo json_encode([
        "status" => "error",
        "message" => "Lỗi SQL: " . mysqli_error($conn)
    ]);
}
?>
 