package com.tktick.context;

import com.tktick.model.entity.TkUser;

/**
 * ThreadLocal存取当前登录的用户
 * @author user
 *
 */
public class SessionContextHolder implements AutoCloseable {
	private static final ThreadLocal<TkUser> currentUser = new ThreadLocal<TkUser>();
	
	public static void setCurrentUser(TkUser user) {
        currentUser.set(user);
    }

    public static TkUser getCurrentUser() {
        return currentUser.get();
    }

	@Override
	public void close() throws Exception {
		currentUser.remove();
	}
}
