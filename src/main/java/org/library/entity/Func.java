package org.library.entity;

import org.library.error.InvalidFuncError;
import org.library.utils.Executor;

import java.util.Arrays;
import java.util.function.Consumer;

public enum Func {
    ONE(1, "도서 등록", Executor::register),
    TWO(2, "전체 도서 목록 조회", Executor::showAll),
    THREE(3, "제목으로 도서 검색", Executor::findBookByTitle),
    FOUR(4, "도서 대여", Executor::rent),
    FIVE(5, "도서 반납", Executor::returns),
    SIX(6, "도서 분실", Executor::reportLost),
    SEVEN(7, "도서 삭제", Executor::delete),
    EIGHT(8, "프로그램 종료", Executor::exit);


    private final int value;
    private final String name;
    private final Consumer<Executor> func;


    Func(int value, String name, Consumer<Executor> func) {
        this.value = value;
        this.name = name;
        this.func = func;
    }

    public void call(Executor executor){
        this.func.accept(executor);
    }

    public boolean isValueEqual(int value){
        return this.value == value;
    }

    @Override
    public String toString() {
        return value + ". " + name;
    }

    public static Func of(int value){
        return Arrays.stream(values()).filter(f-> f.isValueEqual(value))
                .findAny()
                .orElseThrow(InvalidFuncError::new);
    }
}