package org.erlide.project.model.impl

import org.erlide.project.model.IBinaryCodeUnit
import org.erlide.project.model.IErlangProject

public class BinaryCodeUnit extends CodeUnit implements IBinaryCodeUnit {

    new(IErlangProject folder, String name) {
        super(folder, name)
    }

} // BinaryCodeUnit
