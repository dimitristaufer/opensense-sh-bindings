/**
 * Copyright (c) 2014,2018 Contributors to the Eclipse Foundation
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.smarthome.binding.opensensenetwork.internal;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.ThingTypeUID;
import org.eclipse.smarthome.core.thing.binding.BaseThingHandlerFactory;
import org.eclipse.smarthome.core.thing.binding.ThingHandler;
import org.eclipse.smarthome.core.thing.binding.ThingHandlerFactory;
import org.osgi.service.component.annotations.Component;

/**
 * The {@link OpenSenseNetworkHandlerFactory} is responsible for creating things and thing
 * handlers.
 *
 * @author Dimitri Jan Staufer
 * @author Mateusz Kedzierski
 * @author Maksym Koliesnikov
 * @author Manisha Nagbanshi
 * @author Roman Zabrovarny
 *
 */
@NonNullByDefault
@Component(configurationPid = "binding.opensensenetwork", service = ThingHandlerFactory.class)
public class OpenSenseNetworkHandlerFactory extends BaseThingHandlerFactory {

    private static final Set<ThingTypeUID> SUPPORTED_THING_TYPES_UIDS = Stream
            .of(OpenSenseNetworkBindingConstants.SUPPORTED_THING_TYPES_UIDS).flatMap(x -> x.stream())
            .collect(Collectors.toSet());

    @Override
    public boolean supportsThingType(ThingTypeUID thingTypeUID) {
        return SUPPORTED_THING_TYPES_UIDS.contains(thingTypeUID);
    }

    @Override
    protected @Nullable ThingHandler createHandler(Thing thing) {
        ThingTypeUID thingTypeUID = thing.getThingTypeUID();

        if (OpenSenseNetworkBindingConstants.THING_TYPE_RECEIVE.equals(thingTypeUID)) {
            return new OpenSenseNetworkHandler(thing);
        }

        if (OpenSenseNetworkBindingConstants.THING_TYPE_CONTRIBUTE.equals(thingTypeUID)) {
            return new OpenSenseNetworkHandler(thing);
        }

        return null;
    }
}
