
do_patch:append() {
    bb.build.exec_func('do_sed_paths', d)
}

do_sed_paths () {
	sed -i 's/https:\/\/github.com\/google\/flatbuffers\/archive\/v/http:\/\/127.0.0.1\/mydir\/nxp\/file\/flatbuffers-/g' ${S}/third_party/flatbuffers/workspace.bzl
}
