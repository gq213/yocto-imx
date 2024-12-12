LICENSE = "CLOSED"

inherit systemd

SRC_URI = "\
  file://wifi/8188eu.ko \
  file://wifi/wpa_supplicant-gq-wlan0.conf \
  file://wifi/wpa_supplicant-gq.service \
  file://wifi/insmod_ko.service \
  file://wifi/80-wifi-station.network \
  file://audio/HiFi.conf \
  file://audio/TLV320AIC3x-Card.conf \
  file://ml/1_1.0_224_labels.txt \
  file://ml/coco_labels.txt \
  file://ml/detect_example.mov \
  file://ml/id_example.mov \
  file://ml/key_point_labels.txt \
  file://ml/mobilenet_ssd_v2_coco_quant_postprocess.tflite \
  file://ml/mobilenet_v1_1.0_224_quant.tflite \
  file://ml/pose_example.mov \
  file://ml/posenet_resnet50_uint8_float32_quant.tflite \
"

S = "${WORKDIR}"

do_install() {
	install -d ${D}/lib/modules/
	install -d ${D}/etc/
	install -d ${D}${systemd_system_unitdir}
	install -d ${D}/lib/systemd/network/
	install -m 0644 wifi/8188eu.ko ${D}/lib/modules/
	install -m 0644 wifi/wpa_supplicant-gq-wlan0.conf ${D}/etc/
	install -m 0644 wifi/wpa_supplicant-gq.service ${D}${systemd_system_unitdir}
	install -m 0644 wifi/insmod_ko.service ${D}${systemd_system_unitdir}
	install -m 0644 wifi/80-wifi-station.network ${D}/lib/systemd/network/
	
	install -d ${D}/usr/share/alsa/ucm2/conf.d/simple-card/
	install -d ${D}/usr/share/alsa/ucm2/NXP/TLV320AIC3x/
	install -m 0644 audio/TLV320AIC3x-Card.conf ${D}/usr/share/alsa/ucm2/conf.d/simple-card/
	install -m 0644 audio/HiFi.conf ${D}/usr/share/alsa/ucm2/NXP/TLV320AIC3x/
	
	install -d ${D}/home/root/.cache/gopoint/
	install -m 0644 ml/* ${D}/home/root/.cache/gopoint/
}

PACKAGES =+ " \
    ${PN}-wpa-supplicant-gq \
    ${PN}-insmod-ko \
"

SYSTEMD_PACKAGES = "${PN}-wpa-supplicant-gq ${PN}-insmod-ko"

SYSTEMD_SERVICE:${PN}-wpa-supplicant-gq = "wpa_supplicant-gq.service"
SYSTEMD_SERVICE:${PN}-insmod-ko = "insmod_ko.service"

FILES:${PN} = "/"

PACKAGE_ARCH = "${MACHINE_SOCARCH}"
COMPATIBLE_MACHINE = "(mx8mp-nxp-bsp)"
