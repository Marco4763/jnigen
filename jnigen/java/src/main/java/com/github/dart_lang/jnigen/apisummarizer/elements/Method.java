// Copyright (c) 2022, the Dart project authors. Please see the AUTHORS file
// for details. All rights reserved. Use of this source code is governed by a
// BSD-style license that can be found in the LICENSE file.

package com.github.dart_lang.jnigen.apisummarizer.elements;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Method {
  public Set<String> modifiers = new HashSet<>();
  public String name;
  public List<TypeParam> typeParams = new ArrayList<>();
  public List<Param> params = new ArrayList<>();
  public TypeUsage returnType;

  public JavaDocComment javadoc;
  public List<JavaAnnotation> annotations = new ArrayList<>();
}
