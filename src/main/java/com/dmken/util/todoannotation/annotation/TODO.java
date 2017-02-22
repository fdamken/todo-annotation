/*-
 * #%L
 * @TODO
 * %%
 * Copyright (C) 2017 Fabian Damken
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package com.dmken.util.todoannotation.annotation;

import javax.tools.Diagnostic.Kind;

/**
 * Marks the tagged element that there is some work to do. This causes the
 * compiler to show a message (default: warning).
 *
 * <p>
 * <b> NOTE: This annotation is removed at compile time and is not accessible at
 * runtime! </b>
 * </p>
 *
 * @author Fabian Damken
 */
public @interface TODO {
    /**
     * The name of this class ({@value #CLASS_NAME});
     *
     */
    String CLASS_NAME = "com.dmken.util.todoannotation.annotation.TODO";

    /**
     * The message to be displayed in the compiler message.
     *
     * @return The message.
     */
    String value() default "";

    /**
     * The {@link Kind severity} of the message.
     *
     * @return The {@link Kind severity}. Defaults to {@link Kind#WARNING
     *         warning}.
     */
    Kind severity() default Kind.WARNING;
}
