package com.knubisoft.tasks.test;

public class AspectClass {

    /*public void processSecurity(final ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Class<?>[] interfaces = pjp.getTarget().getClass().getInterfaces();
        Operation operation = getOperation(signature, interfaces);
        if (operation != null && operation.security().length != 0) {
            authenticationHandler.authenticate(operation.security());
        }
        pjp.proceed();
    }

    private Operation getOperation(final MethodSignature signature,
                                   final Class<?>[] interfaces) {
        Operation operation = null;
        for (Class<?> i : interfaces) {
            Method method = i.getDeclaredMethod(signature.getName(), signature.getMethod().getParameterTypes());
            if (method.getAnnotation(Operation.class) != null) {
                operation = method.getAnnotation(Operation.class);
            }
        }
        return operation;
    }*/
}
//Обрабатывает перехваченный вызов метода, и если
//он аннотирован специальной аннотацией, запускается процесс аутентификации
