package com.example.testing.example11.screens.common.controllers;

public interface BackPressDispatcher {
    void registerListener(BackPressedListener listener);
    void unregisterListener(BackPressedListener listener);
}
