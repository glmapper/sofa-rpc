/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alipay.sofa.rpc.registry.consul.model;

import com.alipay.sofa.rpc.registry.consul.common.ConsulURL;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 消费者通知器
 *
 * @author <a href=mailto:preciousdp11@gmail.com>dingpeng</a>
 */
public class NotifyConsumerListener implements NotifyListener {

    private ConsulURL                        subscribeUrl;

    private AtomicReference<List<ConsulURL>> providerUrls;

    public NotifyConsumerListener(ConsulURL subscribeUrl, List<ConsulURL> urls) {

        this.subscribeUrl = subscribeUrl;
        this.providerUrls = new AtomicReference<List<ConsulURL>>(urls);

    }

    @Override
    public void notify(ConsulURL subscribeUrl, List<ConsulURL> urls) {
        this.providerUrls = new AtomicReference<List<ConsulURL>>(urls);
    }
}
