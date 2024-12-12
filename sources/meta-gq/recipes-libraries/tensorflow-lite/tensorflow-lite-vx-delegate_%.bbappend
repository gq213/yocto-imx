FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://0002-copy-file.patch \
"

do_patch:append() {
    bb.build.exec_func('do_sed_paths', d)
}

do_sed_paths () {
	sed -i 's/https:\/\/github.com\/Maratyszcza\/pthreadpool\/archive\//http:\/\/127.0.0.1\/mydir\/nxp\/file\/pthreadpool-/g' ${S}/../tfgit/tensorflow/lite/cmake/DownloadPThreadPool.cmake
	sed -i 's/https:\/\/gitlab.com/git:\/\/127.0.0.1/g' ${S}/../tfgit/tensorflow/lite/tools/cmake/modules/eigen.cmake
	sed -i 's/Partial-changes-for-fixing-runtime-setup-issue/modify-url/g' ${S}/../tfgit/tensorflow/lite/tools/cmake/modules/xnnpack.cmake
	sed -i 's/https:\/\/github.com\/petewarden\/OouraFFT\/archive\//http:\/\/127.0.0.1\/mydir\/nxp\/file\/fft2d-/g' ${S}/../tfgit/tensorflow/workspace2.bzl
	sed -i 's/https:\/\/github.com\/intel\/ARM_NEON_2_x86_SSE\/archive\//http:\/\/127.0.0.1\/mydir\/nxp\/file\/ARM_NEON_2_x86_SSE-/g' ${S}/../tfgit/tensorflow/workspace2.bzl
	sed -i 's/https:\/\/github.com\/google\/flatbuffers\/archive\/v/http:\/\/127.0.0.1\/mydir\/nxp\/file\/flatbuffers-/g' ${S}/../tfgit/third_party/flatbuffers/workspace.bzl
	mv ${S}/0001-modify-url.patch ${S}/../tfgit/tensorflow/lite/tools/cmake/modules/xnnpack/patches/
}
