/*
 * Copyright (c) 2016 Pantheon Technologies s.r.o. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.opendaylight.openflowplugin.impl.protocol.serialization.actions;

import io.netty.buffer.ByteBuf;
import org.opendaylight.openflowjava.protocol.impl.util.ActionConstants;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.Action;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.SetMplsTtlActionCase;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.set.mpls.ttl.action._case.SetMplsTtlAction;

public class SetMplsTtlActionSerializer extends AbstractActionSerializer {
    @Override
    public void serialize(Action action, ByteBuf outBuffer) {
        super.serialize(action, outBuffer);
        final SetMplsTtlAction setMplsTtlAction = SetMplsTtlActionCase.class.cast(action).getSetMplsTtlAction();
        outBuffer.writeByte(setMplsTtlAction.getMplsTtl());
        outBuffer.writeZero(ActionConstants.SET_MPLS_TTL_PADDING);
    }

    @Override
    protected int getLength() {
        return ActionConstants.GENERAL_ACTION_LENGTH;
    }

    @Override
    protected int getType() {
        return ActionConstants.SET_MPLS_TTL_CODE;
    }
}
