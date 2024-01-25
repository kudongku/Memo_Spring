package com.sparta.memo.service;

import com.sparta.memo.dto.MemoRequestDto;
import com.sparta.memo.dto.MemoResponseDto;
import com.sparta.memo.entity.Memo;
import com.sparta.memo.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoService {
    private final MemoRepository memoRepository;


    public List<MemoResponseDto> getMemos() {
        return memoRepository.findAll()
                .stream()
                .map(MemoResponseDto::new)
                .toList();
    }

    public void saveMemos(MemoRequestDto memoRequestDto) {
        Memo memo = new Memo(memoRequestDto);
        memoRepository.save(memo);
    }
}
