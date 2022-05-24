<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Detail</title>
  <style>
    table,
    th,
    td {
      border: 1px solid black;
    }
  </style>
</head>

<body>
  <table>
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Mark</th>
      <th>Address</th>
      <th>Image</th>
      <th>Note</th>
      <th>ID Class</th>
    </tr>
    <tr>
      <td>${student_detail.getId()}</td>
      <td>${student_detail.getName()}</td>
      <td>${student_detail.getMark()}</td>
      <td>${student_detail.getAddress()}</td>
      <td>${student_detail.getImage()}</td>
      <td>${student_detail.getNote()}</td>
      <td>${student_detail.getIdclass()}</td>
      <td>
        <a href="http://localhost:8082/students/${student_detail.getId()}/edit">Edit</a>
      </td>
      <td>
        <a href="http://localhost:8082/students/delete/${student_detail.getId()}">Delete</a>
      </td>
    </tr>
  </table>
  <a href="http://localhost:8082/students">Go back</a>
</body>

</html>