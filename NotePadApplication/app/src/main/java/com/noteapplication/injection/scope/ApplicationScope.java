/*
 *  Copyright © 2018, Cognizant Technology Solutions.
 *  Written under contract by Robosoft Technologies Pvt. Ltd.
 */

package com.noteapplication.injection.scope;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Scope
@Retention(RUNTIME)
public @interface ApplicationScope {
}
