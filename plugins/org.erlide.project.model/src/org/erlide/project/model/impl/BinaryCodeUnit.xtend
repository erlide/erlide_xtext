package org.erlide.project.model.impl

import org.erlide.project.model.IBinaryCodeUnit
import org.erlide.project.model.ICodeFolder

public class BinaryCodeUnit extends CodeUnit implements IBinaryCodeUnit {

    new(ICodeFolder folder, String name) {
        super(folder, name)
    }

} // BinaryCodeUnit
