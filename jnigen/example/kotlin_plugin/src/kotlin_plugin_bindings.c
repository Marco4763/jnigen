// Autogenerated by jnigen. DO NOT EDIT!

#include <stdint.h>
#include "dartjni.h"
#include "jni.h"

thread_local JNIEnv* jniEnv;
JniContext* jni;

JniContext* (*context_getter)(void);
JNIEnv* (*env_getter)(void);

void setJniGetters(JniContext* (*cg)(void), JNIEnv* (*eg)(void)) {
  context_getter = cg;
  env_getter = eg;
}

// Example
jclass _c_Example = NULL;

jmethodID _m_Example__ctor = NULL;
FFI_PLUGIN_EXPORT
JniResult Example__ctor() {
  load_env();
  load_class_global_ref(&_c_Example, "Example");
  if (_c_Example == NULL)
    return (JniResult){.value = {.j = 0}, .exception = check_exception()};
  load_method(_c_Example, &_m_Example__ctor, "<init>", "()V");
  if (_m_Example__ctor == NULL)
    return (JniResult){.value = {.j = 0}, .exception = check_exception()};
  jobject _result = (*jniEnv)->NewObject(jniEnv, _c_Example, _m_Example__ctor);
  return to_global_ref_result(_result);
}

jmethodID _m_Example__thinkBeforeAnswering = NULL;
FFI_PLUGIN_EXPORT
JniResult Example__thinkBeforeAnswering(jobject self_, jobject continuation) {
  load_env();
  load_class_global_ref(&_c_Example, "Example");
  if (_c_Example == NULL)
    return (JniResult){.value = {.j = 0}, .exception = check_exception()};
  load_method(_c_Example, &_m_Example__thinkBeforeAnswering,
              "thinkBeforeAnswering",
              "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;");
  if (_m_Example__thinkBeforeAnswering == NULL)
    return (JniResult){.value = {.j = 0}, .exception = check_exception()};
  jobject _result = (*jniEnv)->CallObjectMethod(
      jniEnv, self_, _m_Example__thinkBeforeAnswering, continuation);
  return to_global_ref_result(_result);
}
