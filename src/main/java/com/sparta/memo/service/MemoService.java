package com.sparta.memo.service;

import com.sparta.memo.dto.MemoRequestDto;
import com.sparta.memo.dto.MemoResponseDto;
import com.sparta.memo.entity.Memo;
import com.sparta.memo.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public void updateMemos(Long id, MemoRequestDto memoRequestDto) {
        Memo memo = findById(id);
        memo.update(memoRequestDto);
    }

    private Memo findById(Long id) {
        return memoRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("그런 id의 memo는 없습니다.")
        );
    }
}
