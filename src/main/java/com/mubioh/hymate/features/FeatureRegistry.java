package com.mubioh.hymate.features;

import com.mubioh.hymate.features.autotip.AutoTipFeature;
import com.mubioh.hymate.features.gamequeue.GameQueueFeature;

import java.util.List;

public class FeatureRegistry {
    private static final List<Feature> FEATURES = List.of(
            new GameQueueFeature(),
            new AutoTipFeature()
    );

    public static void initialize() {
        FEATURES.forEach(Feature::initialize);
    }
}
