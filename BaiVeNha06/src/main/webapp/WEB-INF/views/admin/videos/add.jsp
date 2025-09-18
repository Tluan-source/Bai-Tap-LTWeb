<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Video</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">
<style>
    body {
        background: linear-gradient(135deg, #0f172a, #1e293b);
        color: #f1f5f9;
        font-family: 'Segoe UI', sans-serif;
        padding: 30px;
        min-height: 100vh;
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
        display: flex;
        justify-content: space-between;
        align-items: center;
    }

    .card-header a {
        margin-left: 10px;
        color: white;
        transition: transform .2s, box-shadow .2s;
    }

    .card-header a:hover {
        transform: translateY(-2px);
        box-shadow: 0 4px 10px rgba(0,0,0,0.3);
    }

    .btn-primary:hover {
        background-color: #2563eb;
    }

    @keyframes fadeInUp {
        from { opacity: 0; transform: translateY(20px); }
        to   { opacity: 1; transform: translateY(0); }
    }

    input, select, textarea {
        background-color: rgba(255,255,255,0.1);
        color: white;
        border: 1px solid rgba(255,255,255,0.2);
    }

    input::placeholder, textarea::placeholder {
        color: rgba(255,255,255,0.6);
    }

    .form-check-label {
        color: #f1f5f9;
    }

</style>
</head>
<body>
<section class="row">
<div class="col-6 offset-3 mt-4">
<form action="<c:url value='/admin/videos/saveOrUpdate' />" method="POST">
<div class="card">
    <div class="card-header">
        <span><i class="fas fa-video"></i> Add New Video</span>
        <span>
            <a href="<c:url value='/admin/videos'/>" class="btn btn-success btn-sm"><i class="fas fa-bars"></i> List Videos</a>
        </span>
    </div>
    <div class="card-body">
        <div class="mb-3">
            <label for="videoId" class="form-label">Video ID:</label>
            <input type="text" readonly class="form-control" value="${video.id}" id="id" name="id" placeholder="Video Id">
        </div>
        <div class="mb-3">
            <label for="title" class="form-label">Title:</label>
            <input type="text" class="form-control" value="${video.title}" id="title" name="title" placeholder="Video Title" required>
        </div>
        <div class="mb-3">
            <label for="href" class="form-label">Video URL:</label>
            <input type="text" class="form-control" value="${video.href}" id="href" name="href" placeholder="Video URL" required>
        </div>
        <div class="mb-3">
            <label for="poster" class="form-label">Poster URL:</label>
            <input type="text" class="form-control" value="${video.poster}" id="poster" name="poster" placeholder="Poster URL">
        </div>
        <div class="mb-3">
            <label for="description" class="form-label">Description:</label>
            <textarea class="form-control" id="description" name="description" rows="3" placeholder="Video Description">${video.description}</textarea>
        </div>
        <div class="mb-3">
            <label for="categoryId" class="form-label">Category:</label>
            <select class="form-control" id="categoryId" name="category.id" required>
                <option value="">Select Category</option>
                <c:forEach items="${categories}" var="category">
                    <option value="${category.id}" ${video.category.id == category.id ? 'selected' : ''}>${category.categoryName}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mb-3 row">
            <div class="col">
                <label for="views" class="form-label">Views:</label>
                <input type="number" class="form-control" value="${video.views}" id="views" name="views" placeholder="Views">
            </div>
            <div class="col">
                <label for="shares" class="form-label">Shares:</label>
                <input type="number" class="form-control" value="${video.shares}" id="shares" name="shares" placeholder="Shares">
            </div>
        </div>
        <div class="mb-3 form-check">
            <input type="checkbox" class="form-check-input" id="isActive" name="isActive" value="true" ${video.isActive ? 'checked' : ''}>
            <label class="form-check-label" for="isActive">Is Active</label>
        </div>
    </div>
    <div class="card-footer text-muted d-flex justify-content-between">
        <a href="<c:url value='/admin/videos/add'/>" class="btn btn-secondary"><i class="fas fa-new"></i> New</a>
        <button class="btn btn-primary" type="submit"><i class="fas fa-save"></i> Submit</button>
    </div>
</div>
</form>
</div>
</section>
</body>
</html>
