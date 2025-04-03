package com.pharma.reference.infrastructure.lock.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Supplier;

import com.pharma.reference.infrastructure.lock.CompanyLockManager;

public class DefaultCompanyLockManager implements CompanyLockManager {
    private final Map<String, Lock> locks = new ConcurrentHashMap<>();

    @Override
    public <T> T withLock(String companyName, Supplier<T> action) {
        Lock lock = locks.computeIfAbsent(companyName, key -> new ReentrantLock());
        lock.lock();
        try {
            return action.get();
        } finally {
            lock.unlock();
        }
    }
}
