<?php
include 'connection.php';

$xcoord = $_GET["x"];
$ycoord = $_GET["y"];
$user = $_GET["user"];

$sql = "UPDATE users SET x='$xcoord' AND y='$ycoord' WHERE username='$user';";
$result = $conn->query($sql);

if ($conn->query($sql) === TRUE) {
    echo "Record updated successfully";
} else {
    echo "Error updating record: " . $conn->error;
}

$conn->close();
?>
