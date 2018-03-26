<?php
include 'connection.php';

$xcoord = $_GET["x"];
$ycoord = $_GET["y"];
$value = $_GET["value"];

$sql = "SELECT * FROM map WHERE x = '$xcoord' AND y = '$ycoord';";
$result = $conn->query($sql);

if ($result->num_rows > 0)
{
    while ($row = $result->fetch_assoc())
    {
        $row["weight"];
        $sql = "INSERT INTO map (firstname, lastname, email) VALUES ('John', 'Doe', 'john@example.com')";

        if ($conn->query($sql) === TRUE) {
            echo "New record created successfully";
        } else {
            echo "Error: " . $sql . "<br>" . $conn->error;
        }
    }
}
else
{
    $sql = "INSERT INTO map (firstname, lastname, email) VALUES ('John', 'Doe', 'john@example.com')";

    if ($conn->query($sql) === TRUE) {
        echo "New record created successfully";
    } else {
        echo "Error: " . $sql . "<br>" . $conn->error;
    }
}

$conn->close();

?>
