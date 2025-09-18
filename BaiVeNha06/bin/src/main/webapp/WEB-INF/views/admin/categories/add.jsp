<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Category</title>

<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Font Awesome -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">

<style>
    body {
        background: linear-gradient(135deg, #0f172a, #1e293b);
        min-height: 100vh;
        display: flex;
        align-items: center;
        justify-content: center;
        color: #f1f5f9;
        font-family: 'Segoe UI', sans-serif;
    }

    .card {
        background: rgba(30, 41, 59, 0.95);
        border: none;
        border-radius: 16px;
        box-shadow: 0 12px 40px rgba(0,0,0,0.5);
        animation: fadeInUp .6s ease;
    }

    .card-header {
        background: transparent;
        border-bottom: 1px solid rgba(255,255,255,0.1);
        text-align: center;
    }

    .card-header h2 {
        font-size: 1.5rem;
        font-weight: 600;
        color: #38bdf8;
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
        background: linear-gradient(90deg, #22c55e, #16a34a);
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
<section class="container">
<div class="col-md-8 col-lg-6 mx-auto">
<form action="<c:url value='/admin/categories/saveOrUpdate' />" method="POST">
<div class="card p-4">
    <div class="card-header">
        <h2><i class="fas fa-plus-circle"></i> Add New Category</h2>
    </div>
    <div class="card-body">
        <div class="mb-3">
            <label for="categoryId" class="form-label">Category ID</label>
            <input type="text" readonly="readonly" class="form-control" 
                   value="${category.id}" id="id" name="id" placeholder="Category Id">
        </div>
        <div class="mb-3">
            <label for="categoryname" class="form-label">Category Name</label>
            <input type="text" class="form-control" 
                   value="${category.categoryName}" id="name" name="categoryName" placeholder="Category Name">
        </div>
        <div class="mb-3">
            <label for="images" class="form-label">Images</label>
            <input type="text" class="form-control" 
                   value="${category.images}" id="images" name="images" placeholder="Image URL">
        </div>
    </div>
    <div class="card-footer d-flex justify-content-between">
        <a href="<c:url value='/admin/categories/add'/>" class="btn btn-secondary">
            <i class="fas fa-file"></i> New
        </a>
        <a href="<c:url value='/admin/categories' />" class="btn btn-success">
            <i class="fas fa-bars"></i> List
        </a>
        <button class="btn btn-primary" type="submit">
            <i class="fas fa-save"></i> Save
        </button>
    </div>
</div>
</form>
</div>
</section>
</body>
</html>
