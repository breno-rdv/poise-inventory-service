package com.poise.inventory_service.shared.application;

public interface UseCase<I, O> {
    O execute(I input);
}