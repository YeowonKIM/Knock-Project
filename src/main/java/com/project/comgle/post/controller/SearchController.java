package com.project.comgle.post.controller;

import com.project.comgle.admin.repository.CategoryRepository;
import com.project.comgle.post.dto.SearchPageResponseDto;
import com.project.comgle.global.security.UserDetailsImpl;
import com.project.comgle.post.dto.SearchResponseDto;
import com.project.comgle.post.repository.PostRepository;
import com.project.comgle.post.service.SearchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "SEARCH", description = "게시글 조건 조회 관련 API Document")
public class SearchController {

    private final SearchService searchService;

    @Operation(summary = "키워드 조회 API", description = "제목, 내용, 키워드로 검색하는 기능입니다.")
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/search")
    public List<SearchResponseDto> keywordSearch(@RequestParam("k") String keyword, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return searchService.searchKeyword(keyword, userDetails.getCompany());
    }

    @Operation(summary = "카테고리 조회 API", description = "해당 카테고리로 조회하는 기능입니다.")
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/category")
    public SearchPageResponseDto categorySearch(@RequestParam("c") String category, @RequestParam("p") int page, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return searchService.searchCategory(category, page, userDetails.getMember());
    }
    
}
