<?php
include 'connection.php';

$sql = "SELECT * FROM users;";
$result = $conn->query($sql);
$response = [];

if ($result->num_rows > 0)
{
    while ($row = $result->fetch_assoc())
    {
        $response[] = $row;
    }
}

$response = json_encode($response);
echo $response;
?>
