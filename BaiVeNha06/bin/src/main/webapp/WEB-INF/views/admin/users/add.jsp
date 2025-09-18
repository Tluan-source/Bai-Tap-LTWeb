<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add User</title>

<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Font Awesome -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">

<style>
    body {
        background: linear-gradient(135deg, #0f172a, #1e293b);
        min-height: 100vh;
        padding: 30px;
        color: #f1f5f9;
        font-family: 'Segoe UI', sans-serif;
    }

    .card {
        background: rgba(30,41,59,0.95);
        border-radius: 16px;
        border: none;
        box-shadow: 0 12px 40px rgba(0,0,0,0.4);
        animation: fadeInUp .6s ease;
    }

    .card-header {
        background: linear-gradient(90deg, #3b82f6, #2563eb);
        border-radius: 16px 16px 0 0;
        color: white;
        padding: 15px 20px;
        font-weight: 600;
        font-size: 1.5rem;
    }

    .form-control {
        background: rgba(255,255,255,0.05);
        border: 1px solid rgba(255,255,255,0.2);
        border-radius: 10px;
        color: #f1f5f9;
        transition: all .2s;
    }

    .form-control:focus {
        border-color: #38bdf8;
        box-shadow: 0 0 0 3px rgba(56,189,248,0.3);
        background: rgba(255,255,255,0.08);
    }

    .form-check-input {
        cursor: pointer;
    }

    .form-check-label {
        color: #f1f5f9;
        font-weight: 500;
    }

    .card-footer {
        display: flex;
        gap: 10px;
        justify-content: flex-end;
        padding: 15px 20px;
    }

    .btn {
        border-radius: 10px;
        transition: transform .2s ease, box-shadow .2s ease;
    }

    .btn:hover {
        transform: translateY(-2px);
        box-shadow: 0 6px 20px rgba(0,0,0,0.3);
    }

    .btn-primary {
        background: linear-gradient(90deg, #3b82f6, #2563eb);
        border: none;
    }

    .btn-success {
        background: linear-gradient(90deg, #10b981, #047857);
        border: none;
    }

    .btn-secondary {
        background: linear-gradient(90deg, #6b7280, #4b5563);
        border: none;
    }

    @keyframes fadeInUp {
        from { opacity: 0; transform: translateY(20px); }
        to   { opacity: 1; transform: translateY(0); }
    }
</style>
</head>
<body>
<section class="row justify-content-center">
<div class="col-6 mt-4">
<form action="<c:url value='/admin/users/saveOrUpdate' />" method="POST">
<div class="card">
    <div class="card-header">
        <i class="fas fa-user-plus"></i> Add New User
    </div>
    <div class="card-body">
        <div class="mb-3">
            <label for="userId" class="form-label">User ID:</label>
            <input type="text" readonly class="form-control" value="${user.id}" id="id" name="id" placeholder="User Id">
        </div>
        <div class="mb-3">
            <label for="username" class="form-label">Username:</label>
            <input type="text" class="form-control" value="${user.username}" id="username" name="username" placeholder="Username" required>
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Password:</label>
            <input type="password" class="form-control" value="${user.password}" id="password" name="password" placeholder="Password" required>
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Email:</label>
            <input type="email" class="form-control" value="${user.email}" id="email" name="email" placeholder="Email" required>
        </div>
        <div class="mb-3">
            <label for="fullname" class="form-label">Full Name:</label>
            <input type="text" class="form-control" value="${user.fullname}" id="fullname" name="fullname" placeholder="Full Name" required>
        </div>
        <div class="mb-3">
            <label for="images" class="form-label">Images:</label>
            <input type="text" class="form-control" value="${user.images}" id="images" name="images" placeholder="Image URL">
        </div>
        <div class="mb-3 form-check">
            <input type="checkbox" class="form-check-input" id="isAdmin" name="isAdmin" value="true" ${user.isAdmin ? 'checked' : ''}>
            <label class="form-check-label" for="isAdmin">Is Admin</label>
        </div>
        <div class="mb-3 form-check">
            <input type="checkbox" class="form-check-input" id="isActive" name="isActive" value="true" ${user.isActive ? 'checked' : ''}>
            <label class="form-check-label" for="isActive">Is Active</label>
        </div>
    </div>
    <div class="card-footer">
        <a href="<c:url value='/admin/users/add'/>" class="btn btn-secondary">
            <i class="fas fa-plus"></i> New
        </a>
        <a href="<c:url value='/admin/users' />" class="btn btn-success">
            <i class="fas fa-list"></i> List Users
        </a>
        <button class="btn btn-primary" type="submit">
            <i class="fas fa-save"></i> Submit
        </button>
    </div>
</div>
</form>
</div>
</section>
</body>
</html>
