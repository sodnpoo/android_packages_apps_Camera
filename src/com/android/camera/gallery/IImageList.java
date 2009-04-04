/*
 * Copyright (C) 2009 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.camera.gallery;

import android.net.Uri;
import android.os.Handler;

import java.util.HashMap;

/**
 * The interface of all image collections used in gallery.
 */
public interface IImageList {
    public HashMap<String, String> getBucketIds();

    /**
     * Notify interface when the image list has been changed.
     */
    public interface OnChange {
        public void onChange(IImageList list);
    }

    /**
     * Notify interface of how many thumbnails are processed.
     */
    public interface ThumbCheckCallback {
        public boolean checking(int current, int count);
    }

    public abstract void checkThumbnails(
            IImageList.ThumbCheckCallback cb, int totalCount);

    public abstract void commitChanges();

    public abstract void deactivate();

    /**
     * Returns the count of image objects.
     *
     * @return       the number of images
     */
    public abstract int getCount();

    /**
     * @return true if the count of image objects is zero.
     */

    public abstract boolean isEmpty();

    /**
     * Returns the image at the ith position.
     *
     * @param i     the position
     * @return      the image at the ith position
     */
    public abstract IImage getImageAt(int i);

    /**
     * Returns the image with a particular Uri.
     *
     * @param uri
     * @return      the image with a particular Uri.
     */
    public abstract IImage getImageForUri(Uri uri);

    /**
     *
     * @param image
     * @return true if the image was removed.
     */
    public abstract boolean removeImage(IImage image);

    /**
     * Removes the image at the ith position.
     * @param i     the position
     */
    public abstract void removeImageAt(int i);

    public abstract void removeOnChangeListener(
            IImageList.OnChange changeCallback);

    public abstract void setOnChangeListener(
            IImageList.OnChange changeCallback, Handler h);
}