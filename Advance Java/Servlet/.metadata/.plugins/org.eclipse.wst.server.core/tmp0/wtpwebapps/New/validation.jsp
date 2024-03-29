<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <link href="https://fonts.googleapis.com/css2?family=Lato&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="validate.js">
    <style>
      body {
      margin: 0;
      padding: 0
      }
      * {
      box-sizing: border-box;
      }
      .container,
      .form-box {
      display: block;
      width: 100%;
      }
      body {
      background: #1a9ae2;
      font-family: 'Lato', sans-serif;
      }
      .form-box {
      max-width: 350px;
      margin: 20px auto;
      border-radius: 10px;
      min-height: 200px;
      padding: 30px;
      background: #fff;
      }
      .form-box .input-field {
      margin-bottom: 20px;
      position: relative;
      }
      .form-box input {
      display: block;
      min-height: 20px;
      font-size: 18px;
      padding: 10px;
      width: 100%;
      border-radius: 5px;
      border: 1px solid #ccc;
      }
      .form-box input[type='text'] {
      padding-right: 25px
      }
      .form-box h2 {
      display: block;
      text-align: center;
      font-size: 28px;
      margin-bottom: 40px;
      }
      .form-box label {
      font-size: 20px;
      color: #000000;
      margin-bottom: 5px;
      display: block;
      }
      .form-box input[type='submit'] {
      background: #1a9ae2;
      cursor: pointer;
      color: #fff;
      }
      .form-box .fa {
      position: absolute;
      right: 10px;
      margin-top: -30px;
      }
      .form-box .input-field.error input {
      border-color: #f00;
      border-width: 2px;
      }
      .form-box .input-field.error .fa {
      color: #f00;
      }
      .form-box .input-field.success input {
      border-color: #0b0;
      border-width: 2px;
      }
      .form-box .input-field.success .fa {
      color: #0b0;
      }
      .input-field span {
      display: none;
      }
      .input-field.error span {
      color: #f00;
      display: block
      }
      .input-field.success span {
      color: #0b0;
      }
    </style>
  </head>
  <body>
    <div class="container">
      <div class="form-box">
        <h2>Create Your Account</h2>
        <div class="input-field">
          <label for="">Username</label>
          <input type="text" id="username" placeholder="username">
          <i class="fa " aria-hidden="true"></i>
          <span></span>
        </div>
        <div class="input-field">
          <label for="">Email</label>
          <input type="text" id="email" placeholder="email address">
          <i class="fa " aria-hidden="true"></i>
          <span></span>
        </div>
        <div class="input-field">
          <label for="">Password</label>
          <input type="text" id="pass1" placeholder="password">
          <i class="fa " aria-hidden="true"></i>
          <span></span>
        </div>
        <div class="input-field">
          <label for="">Confirm Password</label>
          <input type="text" id="pass2" placeholder="confirm password">
          <i class="fa " aria-hidden="true"></i>
          <span></span>
        </div>
        <input type="submit" id="submit" value="Submit">
      </div>
    </div>
    
  </body>
</html>
