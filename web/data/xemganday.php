<?php
include '../conn.php';

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}


$sql = "SELECT * FROM xemganday";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    $data = [];

    while($row = $result->fetch_assoc()) {
        $data[] = $row;
    }
    header('Content-Type: application/json; charset=utf-8');
    echo json_encode($data, JSON_PRETTY_PRINT | JSON_UNESCAPED_UNICODE);
} else {
    echo "0 results found";
}

$conn->close();
?>
