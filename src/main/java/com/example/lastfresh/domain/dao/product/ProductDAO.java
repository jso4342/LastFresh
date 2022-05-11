package com.example.lastfresh.domain.dao.product;


import com.example.lastfresh.mapper.product.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProductDAO {
    private final ProductMapper productMapper;
//    public  getList( ) {}
//    public  get( ) {}
//    public int getTotal( ) {}
//    public void updateReplyCount() {}
}
