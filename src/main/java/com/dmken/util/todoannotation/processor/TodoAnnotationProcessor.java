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
package com.dmken.util.todoannotation.processor;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

import com.dmken.util.todoannotation.annotation.TODO;

/**
 * The annotation processor processing {@link TODO @TODO}.
 *
 * @author Fabian Damken
 */
@SupportedAnnotationTypes(TODO.CLASS_NAME)
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class TodoAnnotationProcessor extends AbstractProcessor {
    /**
     * The {@link ProcessingEnvironment processing environment}. This is used to
     * output errors, warnings, etc..
     *
     */
    private ProcessingEnvironment processingEnv;

    /**
     * {@inheritDoc}
     *
     * @see javax.annotation.processing.AbstractProcessor#init(javax.annotation.processing.ProcessingEnvironment)
     */
    @Override
    public synchronized void init(final ProcessingEnvironment processingEnv) {
        super.init(processingEnv);

        this.processingEnv = processingEnv;
    }

    /**
     * {@inheritDoc}
     *
     * @see javax.annotation.processing.AbstractProcessor#process(java.util.Set,
     *      javax.annotation.processing.RoundEnvironment)
     */
    @Override
    public boolean process(final Set<? extends TypeElement> annotations, final RoundEnvironment roundEnv) {
        System.out.println("Hello");
        if (!roundEnv.processingOver()) {
            for (final Element element : roundEnv.getElementsAnnotatedWith(TODO.class)) {
                final TODO todo = element.getAnnotation(TODO.class);
                String message = "Found @TODO annotation!";
                if (!todo.value().trim().isEmpty()) {
                    message += " Message: " + todo.value().trim();
                }
                this.processingEnv.getMessager().printMessage(todo.severity(), message, element);
            }
        }
        return true;
    }
}
