
SOC_DEFAULT_IMAGE_FSTYPES:remove = " tar.zst"
SOC_DEFAULT_IMAGE_FSTYPES:append = " tar.xz"

IMAGE_INSTALL:append = " file-overlay file-overlay-wpa-supplicant-gq file-overlay-insmod-ko"

modify_rootfs() {
	sed -i 's/Alias/#Alias/g' ${IMAGE_ROOTFS}/lib/systemd/system/wpa_supplicant.service
	rm -r ${IMAGE_ROOTFS}/etc/resolv.conf
	ln -s ../run/systemd/resolve/stub-resolv.conf ${IMAGE_ROOTFS}/etc/resolv.conf
}

ROOTFS_POSTPROCESS_COMMAND += " modify_rootfs; "
