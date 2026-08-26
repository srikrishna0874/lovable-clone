package com.springboot.lovable_clone.entity;

import com.springboot.lovable_clone.enums.PreviewStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Preview {

    Long id;

    Project project;

    String namespace;

    String previewUrl;

    String podName;

    PreviewStatus status;

    Instant startedAt;

    Instant terminatedAt;

    Instant createdAt;

}
