PICLAB 1.0 - readme.txt
=======================

Product Name:   MadLab PICLAB
Version:	1.0
Release Date:   1st December 2000
Distribution:	Commercial release. Unauthorised distribution prohibited.


Contact Information
===================

MadLab Ltd.             Phone: +44 (0)131 530 2001
8 Lochend Road		Fax:   +44 (0)131 530 2002
Edinburgh EH6 8BR       Email: info@madlab.org
UK                      Web:   http://www.madlab.org


System Requirements
===================

Windows 95 or later
386 processor or better
1MB free disk space


Introduction
============

PICLAB functions both as a normal PIC device programmer, and as a tester board for running simple PIC programs.

As a device programmer (where a programmed PIC is destined for some other board), it can program PICs with industry-standard hex files produced by assemblers and compilers, or flowcharts constructed using Crocodile Technology from Crocodile Clips (www.crocodile-clips.com). Support for PICLAB is built in to Crocodile Technology and PICLAB can be controlled from within this application.

As a tester board, Crocodile Technology flowcharts can be downloaded into a PIC and run in situ. PICLAB features a number of on-board peripherals which can be controlled from the flowchart, with good correspondence between the operation of the virtual microcontroller on the PC screen and the physical microcontroller on the bench.

PICLAB is designed to work with Microchip's 18-pin flash PIC family. These devices can be re-programmed without the need for a UV eraser and so are ideal in an educational environment.

PICLAB currently supports the following devices: PIC16F83, PIC16F84, PIC16F84A. Support for new flash PICs will be added in the future.


Installation
============

The software is provided as a self-extracting compressed file. Simply run setup.exe and select the directory you wish to install the files into. If you are using PICLAB in conjunction with Crocodile Technology from Crocodile Clips, this would normally be the sub-directory "PlugIns\MadLab" in your Crocodile Technology directory. If you can't find this directory then use Tools|Find|Files or Folders in Windows Explorer to locate the directory named "MadLab".

Note that the installation of Crocodile Technology 1.5 automatically installs PICLAB to your system. You will only need to run "setup.exe" if you are updating your PICLAB installation, or are installing PICLAB without Crocodile Technology.


Distribution Files
==================

piclab.exe - PICLAB application
piclab.hlp - application help file
piclab.cyt - PICLAB peripherals template
readme.txt - this file

examples\catcher.bas - PBasic program to implement a burglar alarm
examples\clap.bas - PBasic program to count claps
examples\counter.bas - PBasic program to count up in binary and hex
examples\lotto.bas - PBasic program to generate numbers for the National Lottery
examples\reaction.bas - PBasic program to time reactions
examples\tester.bas - PBasic program to test PICLAB
examples\tones.bas - PBasic program to play different tones

examples\music.hex - object code file to play different tunes
examples\music.asm - assembler source code
examples\matilda.tun - Waltzing Mathilda
examples\bluepetr.tun - Blue Peter
examples\thebrave.tun - Scotland The Brave
examples\flower.tun - Flower O' Scotland

source\stub.asm - assembler source code for tester board stub and library

firmware\piclab.hex - PICLAB firmware object code file


Software Updates
================

Download the latest version of PICLAB from the MadLab website (http://www.madlab.org/piclab).

The file "piclab.hex" in the sub-directory "firmware" is the latest version of the PICLAB firmware. You can upgrade your PICLAB by programming a PIC16F84 device and then swapping the newly-programmed chip with the existing chip. Match the notch in the chip with the notch in the socket when doing this.


Copyright & Trademark Notice
============================

PICLAB 1.0 and all related files and documentation are
Copyright (c) 2000 MadLab Ltd.
All Rights Reserved.

MadLab® is a registered service mark of MadLab Ltd. in the UK.
All other trademarks or registered trademarks mentioned are the property of their respective owners.
