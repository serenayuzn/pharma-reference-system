package com.pharma.reference.infrastructure.lock;

import java.util.function.Supplier;

public interface CompanyLockManager {
    <T> T withLock(String companyName, Supplier<T> action);
}
