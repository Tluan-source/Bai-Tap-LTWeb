package com.example.Bai9.gql.mutation;

import com.example.Bai9.entity.*;
import com.example.Bai9.repo.*;
import com.example.Bai9.input.UserInput;
import com.example.Bai9.input.CategoryInput;
import com.example.Bai9.input.ProductInput;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

@Controller
public class CrudMutation {
    private final UserRepository userRepo;
    private final CategoryRepository catRepo;
    private final ProductRepository prodRepo;

    public CrudMutation(UserRepository u, CategoryRepository c, ProductRepository p) {
        this.userRepo = u;
        this.catRepo = c;
        this.prodRepo = p;
    }

    /* ----- User ----- */
    @MutationMapping
    @Transactional
    public User createUser(@Argument UserInput input) {
        User u = User.builder().fullname(input.fullname()).email(input.email()).password(input.password())
                .phone(input.phone()).build();
        return userRepo.save(u);
    }

    @MutationMapping
    @Transactional
    public User updateUser(@Argument Long id, @Argument UserInput input) {
        User u = userRepo.findById(id).orElseThrow();
        u.setFullname(input.fullname());
        u.setEmail(input.email());
        u.setPassword(input.password());
        u.setPhone(input.phone());
        return userRepo.save(u);
    }

    @MutationMapping
    @Transactional
    public Boolean deleteUser(@Argument Long id) {
        userRepo.deleteById(id);
        return true;
    }

    /* ----- Category ----- */
    @MutationMapping
    @Transactional
    public Category createCategory(@Argument CategoryInput input) {
        Category c = Category.builder().name(input.name()).images(input.images()).build();
        return catRepo.save(c);
    }

    @MutationMapping
    @Transactional
    public Category updateCategory(@Argument Long id, @Argument CategoryInput input) {
        Category c = catRepo.findById(id).orElseThrow();
        c.setName(input.name());
        c.setImages(input.images());
        return catRepo.save(c);
    }

    @MutationMapping
    @Transactional
    public Boolean deleteCategory(@Argument Long id) {
        catRepo.deleteById(id);
        return true;
    }

    /* ----- Product ----- */
    @MutationMapping
    @Transactional
    public Product createProduct(@Argument ProductInput input) {
        User owner = userRepo.findById(Long.valueOf(input.userId())).orElseThrow();
        Product p = Product.builder()
                .title(input.title()).quantity(input.quantity()).desc(input.desc())
                .price(java.math.BigDecimal.valueOf(input.price()))
                .user(owner).build();
        if (input.categoryIds() != null) {
            Set<Category> cats = new HashSet<>(
                    catRepo.findAllById(input.categoryIds().stream().map(Long::valueOf).toList()));
            p.setCategories(cats);
        }
        return prodRepo.save(p);
    }

    @MutationMapping
    @Transactional
    public Product updateProduct(@Argument Long id, @Argument ProductInput input) {
        // Tìm sản phẩm theo id
    Product p = prodRepo.findById(id).orElseThrow();

    // Cập nhật từng trường nếu không null
    if (input.title() != null) p.setTitle(input.title());
    if (input.quantity() != null) p.setQuantity(input.quantity());
    if (input.desc() != null) p.setDesc(input.desc());
    if (input.price() != null) {
        p.setPrice(java.math.BigDecimal.valueOf(input.price()));
    }

    // Cập nhật user (chủ sở hữu sản phẩm) nếu có userId mới
    if (input.userId() != null) {
        User owner = userRepo.findById(Long.valueOf(input.userId()))
                             .orElseThrow();
        p.setUser(owner);
    }

    // Cập nhật category list nếu có categoryIds mới
    if (input.categoryIds() != null) {
        Set<Category> cats = new HashSet<>(
            catRepo.findAllById(
                input.categoryIds().stream()
                     .map(Long::valueOf)
                     .toList()
            )
        );
        p.setCategories(cats);
    }

    // Trả về sản phẩm đã được lưu sau khi cập nhật
    return prodRepo.save(p);
    }
}
