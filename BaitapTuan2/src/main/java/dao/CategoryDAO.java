package dao;
import model.Category;
import util.DBConn;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {

	public List<Category> findByUserId(int userId) {
	    List<Category> list = new ArrayList<>();
	    String sql = "SELECT * FROM category WHERE user_id = ?";
	    try (Connection con = DBConn.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {
	        ps.setInt(1, userId);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            Category c = new Category();
	            c.setId(rs.getInt("category_id"));
	            c.setName(rs.getString("name"));
	            c.setDescription(rs.getString("description"));
	            c.setUserId(rs.getInt("user_id"));
	            list.add(c);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return list;
	}

    public boolean insert(Category c) {
        try (Connection conn = DBConn.getConnection()) {
            String sql = "INSERT INTO category(name, description, user_Id) VALUES (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, c.getName());
            ps.setString(2, c.getDescription());
            ps.setInt(3, c.getUserId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(Category c) {
        try (Connection conn = DBConn.getConnection()) {
            String sql = "UPDATE category SET name=?, description=? WHERE category_id=? AND user_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, c.getName());
            ps.setString(2, c.getDescription());
            ps.setInt(3, c.getId());
            ps.setInt(4, c.getUserId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int category_id, int userId) {
        try (Connection conn = DBConn.getConnection()) {
            String sql = "DELETE FROM category WHERE category_id=? AND user_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, category_id);
            ps.setInt(2, userId);
            return ps.executeUpdate() > 0;
		} catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
