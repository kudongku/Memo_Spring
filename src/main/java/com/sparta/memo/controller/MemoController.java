package com.sparta.memo.controller;

import com.sparta.memo.dto.MemoRequestDto;
import com.sparta.memo.dto.MemoResponseDto;
import com.sparta.memo.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemoController {
    private final MemoService memoService;

    @GetMapping("/memos")
    public List<MemoResponseDto> getMemos() {
        return memoService.getMemos();
    }

    @PostMapping("/memos")
    public void saveMemos(@RequestBody MemoRequestDto memoRequestDto) {
        memoService.saveMemos(memoRequestDto);
    }

    @PutMapping("/memos/{id}")
    public void updateMemos(@PathVariable Long id, @RequestBody MemoRequestDto memoRequestDto) {
        memoService.updateMemos(id, memoRequestDto);
    }
}
