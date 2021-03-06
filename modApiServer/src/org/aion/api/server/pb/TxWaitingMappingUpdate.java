/*******************************************************************************
 * Copyright (c) 2017-2018 Aion foundation.
 *
 *     This file is part of the aion network project.
 *
 *     The aion network project is free software: you can redistribute it
 *     and/or modify it under the terms of the GNU General Public License
 *     as published by the Free Software Foundation, either version 3 of
 *     the License, or any later version.
 *
 *     The aion network project is distributed in the hope that it will
 *     be useful, but WITHOUT ANY WARRANTY; without even the implied
 *     warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *     See the GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with the aion network project source files.
 *     If not, see <https://www.gnu.org/licenses/>.
 *
 * Contributors:
 *     Aion foundation.
 *     
 ******************************************************************************/

package org.aion.api.server.pb;

import org.aion.base.util.ByteArrayWrapper;
import org.aion.zero.types.AionTxReceipt;

public class TxWaitingMappingUpdate {
    ByteArrayWrapper txHash;
    AionTxReceipt txReceipt;
    int pState;

    public TxWaitingMappingUpdate(ByteArrayWrapper txHashW, int state, AionTxReceipt txReceipt) {
        this.txHash = txHashW;
        this.pState = state;
        this.txReceipt = txReceipt;
    }

    public ByteArrayWrapper getTxHash() {
        return txHash;
    }

    public AionTxReceipt getTxReceipt() {
        return txReceipt;
    }

    public ByteArrayWrapper getTxResult() {
        return ByteArrayWrapper.wrap(txReceipt.getExecutionResult());
    }

    public int getState() {
        return pState;
    }

    public boolean isDummy() {
        return txHash == null && pState == 0 && txReceipt == null;
    }
}
