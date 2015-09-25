package com.github.duganka.das;

import com.github.duganka.das.domain.User;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author vadik
 */
public class UserRegistry {

    private final ImmutableList<User> users;

    public UserRegistry(final int count) {
        final List<User> users = new ArrayList<>();
        for (int id = 0; id < count; ++id) {
            users.add(new User(id, randomName(5), randomName(10)));
        }
        this.users = ImmutableList.copyOf(users);
    }

    public User randomUser() {
        return users.get(ThreadLocalRandom.current().nextInt(users.size()));
    }

    private static String randomName(final int length) {
        Preconditions.checkArgument(length > 1);
        return RandomStringUtils.randomAlphabetic(1).toUpperCase() + RandomStringUtils.randomAlphabetic(length - 1).toLowerCase();
    }

}
